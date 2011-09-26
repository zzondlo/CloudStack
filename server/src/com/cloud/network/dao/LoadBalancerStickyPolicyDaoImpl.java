/**
 *  Copyright (C) 2010 Cloud.com, Inc.  All rights reserved.
 * 
 * This software is licensed under the GNU General Public License v3 or later.
 * 
 * It is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package com.cloud.network.dao;

import java.util.List;

import javax.ejb.Local;

import com.cloud.network.LoadBalancerStickyPolicyVO;
import com.cloud.utils.db.GenericDaoBase;
import com.cloud.utils.db.SearchCriteria;

@Local(value={LoadBalancerStickyPolicyDao.class})
public class LoadBalancerStickyPolicyDaoImpl extends GenericDaoBase<LoadBalancerStickyPolicyVO, Long> implements LoadBalancerStickyPolicyDao {

    @Override
    public void remove(long loadBalancerId) {
        SearchCriteria<LoadBalancerStickyPolicyVO> sc = createSearchCriteria();
        sc.addAnd("loadBalancerId", SearchCriteria.Op.EQ, loadBalancerId);

        expunge(sc);
    }
    
    @Override
    public void remove(long loadBalancerId,  Boolean revoke) {
        SearchCriteria<LoadBalancerStickyPolicyVO> sc = createSearchCriteria();
        sc.addAnd("loadBalancerId", SearchCriteria.Op.EQ, loadBalancerId);
        if (revoke != null) {
            sc.addAnd("revoke", SearchCriteria.Op.EQ, revoke);
        }

        expunge(sc);
    }


    @Override
    public List<LoadBalancerStickyPolicyVO> listByLoadBalancerId(long loadBalancerId) {
        SearchCriteria<LoadBalancerStickyPolicyVO> sc = createSearchCriteria();
        sc.addAnd("loadBalancerId", SearchCriteria.Op.EQ, loadBalancerId);

        return listBy(sc);
    }

    @Override
    public List<LoadBalancerStickyPolicyVO> listByLoadBalancerId(long loadBalancerId, boolean pending) {
        SearchCriteria<LoadBalancerStickyPolicyVO> sc = createSearchCriteria();
        sc.addAnd("loadBalancerId", SearchCriteria.Op.EQ, loadBalancerId);
        sc.addAnd("revoke", SearchCriteria.Op.EQ, pending);

        return listBy(sc);
    }
    


    
}
