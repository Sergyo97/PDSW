package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.Date;

public interface ItemRentadoMapper {

	/**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(int id, 
            int idit, 
            Date fechainicio,
            Date fechafin);
	
}
