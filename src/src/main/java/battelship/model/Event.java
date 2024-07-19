package battelship.model;
import java.util.UUID;

public abstract class Event implements Comparable<Event> {
   public final UUID id;
   public final long timestamp;

    public Event() {
        this.id = UUID.randomUUID();
        this.timestamp = System.currentTimeMillis();
    }

   public Event(UUID id, long timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }


    //Overide weil Object methode equals anders funktioniert.
    @Override
    public boolean equals(Object object) {
      if( object == null || !(object instanceof Event))
          return false;
      Event other = (Event) object;
      return  this.id.equals(other.id);
    }

    @Override
    public int hashCode(){
        return this.hashCode();
    }

    //Durch vergleich mit compareTo definiert man eine Reihenfolge
    @Override
    public int compareTo(Event other) {
       if(Long.compare(this.timestamp, other.timestamp) == 0){
        //Die untere CompareTo methode nutztz die Compareto von Event
        return this.id.compareTo(other.id);}
            return Long.compare(this.timestamp,other.timestamp);
        }



    public abstract boolean isShipPlacementEvent(Player player);


    public abstract boolean isShotEvent(Player player);

}
