/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.*;
import java.rmi.server.*;

/**
 *
 * @author ruang
 */
public class RMIServerExample extends UnicastRemoteObject implements RMIExampleInterface{
    
    RMIServerExample() throws RemoteException{
        super();
    }

    @Override
    public int add(int x, int y) throws RemoteException {
        return x + y;
    }
    
}
