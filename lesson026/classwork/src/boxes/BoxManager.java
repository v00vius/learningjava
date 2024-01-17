package boxes;

import java.util.*;

public class BoxManager {
static private int idCounter = 0;
private List<HeavyBox> boxes;
private Map<String, List<HeavyBox>> tags;
private Presision presision;

private class Presision {
private float epsilon;

        public Presision(float epsilon)
        {
                this.epsilon = epsilon;
        }
        Presision create(float eps) {
                return new Presision(eps);
        }

        public int compare(float f1, float f2)
        {
                if(Math.abs(f1 - f2) <= epsilon)
                        return 0;

                return f1 < f2 ? -1 : +1;
        }
}

private class byVolume implements Comparator<HeavyBox> {

        @Override
        public int compare(HeavyBox o1, HeavyBox o2)
        {
                return presision.compare(o1.getVolume(), o2.getVolume());
        }
}
private class byMass implements Comparator<HeavyBox> {

        @Override
        public int compare(HeavyBox o1, HeavyBox o2)
        {
                return presision.compare(o1.getMass(), o2.getMass());
        }
}
public BoxManager()
{
        boxes = createBoxList();
        tags = new Hashtable<>();
        presision = new Presision(1e-3f);
}

public HeavyBox createBox(String tag)
{
        HeavyBox b = new HeavyBox(nextId(), tag);

        boxes.add(b);

        List<HeavyBox> myBoxes = tags.get(tag);

        if(myBoxes == null) {
                myBoxes = createBoxList();
                tags.put(tag, myBoxes);
        }

        myBoxes.add(b);

        return b;
}

public Set<HeavyBox> getByVolume()
{
        Set<HeavyBox> byVolume = new TreeSet<>(new byVolume());

        byVolume.addAll(boxes);

        return byVolume;
}
public Set<HeavyBox> getByMass()
{
        Set<HeavyBox> byMass = new TreeSet<>(new byMass());

        byMass.addAll(boxes);

        return byMass;
}
public List<HeavyBox> getBoxes()
{
        return boxes;
}

public List<HeavyBox> getTaggedAs(String tag)
{
        List<HeavyBox> myBoxes = tags.get(tag);

        if(myBoxes == null) {
                myBoxes = createBoxList();
                tags.put(tag, myBoxes);
        }

        return myBoxes;
}
public Map<String, List<HeavyBox>> getTags()
{
        return tags;
}

static private List<HeavyBox> createBoxList() {
       return new LinkedList<>();
}
static private int nextId()
{
        return ++idCounter;
}
}
