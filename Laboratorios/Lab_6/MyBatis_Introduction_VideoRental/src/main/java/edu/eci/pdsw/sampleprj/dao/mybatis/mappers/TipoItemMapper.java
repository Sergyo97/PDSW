package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import java.util.List;

import edu.eci.pdsw.samples.entities.TipoItem;

/**
 *
 * @author 2106913
 */
public interface TipoItemMapper {
    
    
    public List<TipoItem> getTiposItems();
    
    public TipoItem getTipoItem(int id);
    
    public void addTipoItem(String des);

}
