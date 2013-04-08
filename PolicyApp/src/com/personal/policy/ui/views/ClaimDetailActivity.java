package com.personal.policy.ui.views;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.personal.policy.Claim;
import com.personal.policy.R;
import com.personal.policy.net.NetUtils;
import com.personal.policy.ui.ClaimDetailListAdapter;

public class ClaimDetailActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.claim_details);
		
		NetUtils net = new NetUtils();
		List<Claim> claims = net.getClaims("dummy", "dummy");
		
		ClaimDetailListAdapter adapter = new ClaimDetailListAdapter(this, R.layout.claim_detail_list_item, claims);
		
		ListView list = (ListView) findViewById(R.id.claim_list);
		list.setAdapter(adapter);
		
		
	}

}
