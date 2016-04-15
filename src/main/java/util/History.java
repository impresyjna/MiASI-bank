package util;

import operations.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by impresyjna on 15.04.2016.
 */
public class History {
    private List<Operation> operationList = new ArrayList<>();

    public History() {

    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void log(Operation operation){
        operationList.add(operation);
    }
}
