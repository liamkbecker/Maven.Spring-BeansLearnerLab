import java.util.ArrayList;
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

    public void clear(){
        this.personList = new ArrayList<PersonType>();
    }

    public void addAll(Iterable<PersonType> iterable){
        for (PersonType i : iterable) {
            personList.add(i);
        }
    }

    public PersonType findById(long id){
        for (PersonType i : personList) {
            if(i.getId() == id){
                return i;
            }
        }
        return null;
    }

    public List<PersonType> findAll(){
        return this.personList;
    }

}
