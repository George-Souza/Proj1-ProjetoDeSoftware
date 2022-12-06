package Iterator;
import java.util.List;

import Users.Usuario;

public class UserIterator implements Iterator{

    List<Usuario> users;
    int pos = 0;

    public UserIterator(List<Usuario> u){
        users = u;
    }

    @Override
    public boolean hasNext() {
        if(pos >= users.size() || users.get(pos) == null)
            return false;
        else return true;
    }

    @Override
    public Object next() {
        Usuario user = users.get(pos);
        pos++;
        return user;
    }
    
}
