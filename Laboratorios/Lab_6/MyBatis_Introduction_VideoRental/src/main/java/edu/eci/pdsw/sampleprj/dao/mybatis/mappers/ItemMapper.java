package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Item;

/**
 *
 * @author 2138850
 */
public interface ItemMapper {
    
    
    public List<Item> consultarItems();        
    
    public Item consultarItem(@Param("id") int id);
    
    public void insertarItem(@Param("item")Item it);

    public void deleteItem(@Param("id") int id);
        
}
