package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import java.util.List;

import edu.eci.pdsw.samples.entities.Item;

/**
 *
 * @author 2106913
 */
public interface ItemMapper {
    
    
    public List<Item> consultarItems();        
    
    public Item consultarItem(int id);
    
    public void insertarItem(Item it);

        
}
