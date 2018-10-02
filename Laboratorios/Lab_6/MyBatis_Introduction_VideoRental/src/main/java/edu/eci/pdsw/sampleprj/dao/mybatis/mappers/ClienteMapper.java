package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.List;

import edu.eci.pdsw.samples.entities.Cliente;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
    
    public Cliente consultCliente(int id); 
    
    /**
     * Consultar todos los clientes
     * @return 
     */
    public List<Cliente> consultarClientes();
    
}
