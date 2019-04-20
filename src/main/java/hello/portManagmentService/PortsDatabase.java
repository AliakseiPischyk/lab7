package hello.portManagmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.NoSuchElementException;


public class PortsDatabase {

    private List<Port> ports;

    public PortsDatabase(final List<Port> ports){
        this.ports = ports;
    }

    public void addPort (final Port port){
        ports.add(port);
    }

    public Port getAccess(final Integer ID) throws NoSuchElementException {
        for (final Port port : ports){
            if (port.getID() == ID){
                return  port;
            }
        }
        throw new NoSuchElementException();
    }

    public List<Port> getPorts(){
        return ports;
    }
}
