import java.util.List;

public abstract class People<PersonType extends Person> implements Iterable<PersonType> {

    private List<PersonType> personList;

    public People(List<PersonType> personList){
        this.personList = personList;
    }

    public void add(PersonType person){
        personList.add(person);
    }

    public void remove(PersonType person){
        personList.remove(person);
    }

    public int size(){
        return this.personList.size();
    }

}
