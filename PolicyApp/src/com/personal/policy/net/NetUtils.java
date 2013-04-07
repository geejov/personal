package com.personal.policy.net;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.personal.policy.Claim;
import com.personal.policy.Policy;

public class NetUtils {
	
	public Policy getPolicy( String userid ) {
		
		Policy p = new Policy();
		
		p.setHolderName("Geejov S A");
		p.setPolicyNumber("1234567890");
		p.setPremium(1563);
		p.setValidityStart( new Date());
		p.setValidityEnd( new Date());
		p.setSumInsured( 300000 );
		
		p.getDependents().add("Saneesh Joseph");
		p.getDependents().add("Pramod Mohan");
		p.getDependents().add("Jinny Cherian");
		
		
		return p;
	}

	public List<Claim> getClaims( String userid ) {
		
		List<Claim> claims = new ArrayList<Claim>();
		
		Claim claim = new Claim();
		claim.setDependantName("Saneesh Joseph");
		claim.setAmount(12000);
		claim.setApprovedAmount(8900);
		claim.setClaimDate( new Date());
		claim.setClaimStatus("Approved");
		claims.add(claim);
		
		claim = new Claim();
		claim.setDependantName("Rajeev SA");
		claim.setAmount(12000);
		claim.setApprovedAmount(8900);
		claim.setClaimDate( new Date());
		claim.setClaimStatus("Approved");
		claims.add(claim);
		
		claim = new Claim();
		claim.setDependantName("Sajeev S A");
		claim.setAmount(12000);
		claim.setApprovedAmount(8900);
		claim.setClaimDate( new Date());
		claim.setClaimStatus("Approved");
		
		claims.add(claim);
		
		return claims;
		
	}
}
