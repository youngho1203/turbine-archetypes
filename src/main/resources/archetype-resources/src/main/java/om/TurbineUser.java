package ${package}.om;

import java.sql.Connection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.fulcrum.security.model.turbine.entity.TurbineUserGroupRole;
import org.apache.torque.TorqueException;


/**
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Tue Oct 25 15:50:37 CEST 2016]
 *
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 * #set( $H = '#' )
 * Added Interface
 * @author gk
 *
 */
public  class TurbineUser
    extends ${package}.om.BaseTurbineUser implements org.apache.fulcrum.security.model.turbine.entity.TurbineUser
{
    /** Serial version */
    private static final long serialVersionUID = 1477403437136L;
    
   /**
     * Get the value of id.
     *
     * @return Object
     */
    @Override
	public Object getId() 
    {
        
        return getEntityId();
    }

    /**
     * Set the value of id.
     *
     * @param v new value
     */
    @Override
	public void setId(Object v)
    {
        setEntityId( (Integer) v);

    }
    
        /**
     * Get the value of name.
     *
     * @return String
     */
    @Override
	public String getName() 
    {
        
        return getEntityName();
    }

    /**
     * Set the value of name.
     *
     * @param v new value
     */
    @Override
	public void setName(String v)
    {
        setEntityName(v);

    }

}
