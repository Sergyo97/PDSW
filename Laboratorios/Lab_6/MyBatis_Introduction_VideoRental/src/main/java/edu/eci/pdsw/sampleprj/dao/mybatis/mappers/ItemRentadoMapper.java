package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

public interface ItemRentadoMapper {

	/**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(@Param("idir")int id,
            @Param("idit")int idit, 
            @Param("fiir")Date fechainicio,
            @Param("ffir")Date fechafin);
	
}
