/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.blockchain.shopviacrypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crypto.blockchain.shopviacrypto.dto.UserRole;

/**
 *
 * @author avatar
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    
}
