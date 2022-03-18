package uv.parcial1;

public class entry {

    
    public static void main (String [] args) {
        Human male = new Human ("Adan", 50);
        Human female = new Human ("Eva", 45);
        Human [] childs = new Human [3];
        childs[0] = new Human ("Hugo", 20);
        childs[1] = new Human ("Paco", 18);
        childs[2] = new Human ("Luis", 15);

        family<Human> fm = new family<>(male, female, childs);
        fm.getFather().print();
        fm.getMother().print();
        for (int i = 0; i < childs.length; i++) {
            fm.getChild(i).print();
        }
        System.out.println("\n");
        Dog dogMale = new Dog ("Jimmy", 8);
        Dog dogFemale = new Dog ("Julie", 6);
        Dog [] puppies = new Dog [2];
        puppies [0] = new Dog ("toto", 1);
        puppies [1] = new Dog ("nimo", 2);

        family<Dog> fd = new family<>(dogMale, dogFemale,puppies);
        fd.getFather().print ();
        fd.getMother().print ();
        for (int i = 0; i < puppies.length; i++) {
            fd.getChild(i).print();
        }
    }
}
