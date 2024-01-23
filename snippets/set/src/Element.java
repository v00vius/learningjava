public class Element implements Comparable<Element> {
private int id;

public Element(int id) {
    this.id = id;
}

@Override
public int compareTo(Element o) {
    return Integer.compare(id, o.id);
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Element other = (Element) obj;
    if (id != other.id)
        return false;
    return true;
}

@Override
public String toString() {
    return "\nElement [id=" + id + "]";
}

}
