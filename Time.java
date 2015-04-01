public class Time implements Comparable<Time> {

  private int hour, min, sec;

  public Time(int hour, int min, int sec) {
    this.hour = hour;
    this.min = min;
    this.sec = sec;
  }

  public int getHour() {
    return hour;
  }

  public int getMin() {
    return min;
  }

  public int getSec() {
    return sec;
  }

  public Time add(Time time) {
    int nsec = sec + time.sec;
    sec = nsec % 60;
    int nmin = min + time.min + nsec/60;
    min = nmin % 60;
    hour = hour + time.hour + nmin/60;
    return this;
  }

  public boolean equals(Object obj) {
    if (obj instanceof Time) {
      Time other = (Time)obj;
      return hour==other.hour && min==other.min && sec==other.sec;
    }
    else
      return false;
  }

  public int compareTo(Time t) {
      int hdiff = hour - t.hour;
      if(hdiff != 0)
	  return hdiff;
      else {
	  int mdiff = min - t.min;
	  if (mdiff != 0)
	      return mdiff;
	  else {
	      return sec - t.sec;
	  }
      }
  }

  public int hashCode() {
    return sec+(min+hour*60)*60;
  }

  public String toString() {
    return hour+":"+min+":"+sec;
  }
}