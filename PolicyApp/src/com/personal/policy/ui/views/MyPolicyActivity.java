package com.personal.policy.ui.views;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.personal.policy.Policy;
import com.personal.policy.R;
import com.personal.policy.net.NetUtils;
import com.personal.policy.ui.KeyValueListAdapter;
import com.personal.policy.ui.KeyValueListItem;

public class MyPolicyActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.mypolicy);
		
		List<KeyValueListItem> items = new  ArrayList<KeyValueListItem>();
		
		NetUtils net = new NetUtils();
		Policy p = net.getPolicy("dummy");
		
		items.add( new KeyValueListItem("Name",p.getHolderName()));
		items.add( new KeyValueListItem("Policy Number",p.getPolicyNumber()));
		items.add( new KeyValueListItem("Premium", p.getPremium()+""));
		items.add( new KeyValueListItem("Validity From",(p.getValidityStart().getMonth()+1)+"/"
														+(p.getValidityStart().getDate())+"/"
														+(p.getValidityStart().getYear()+1900)) );
		items.add( new KeyValueListItem("Validity To", (p.getValidityEnd().getMonth()+1)+"/"
														+p.getValidityEnd().getDate()+"/"
														+(p.getValidityEnd().getYear()+1900)));
		
		items.add( new KeyValueListItem("Sum Insured", p.getSumInsured()+"") );
		
		
		ListView list = (ListView) findViewById(R.id.mypolicylist);
		KeyValueListAdapter adapter = new KeyValueListAdapter(this, R.layout.mypolicy_list_item, items);
		list.setAdapter(adapter);
		
		
		List<KeyValueListItem> dependents = new  ArrayList<KeyValueListItem>();
		KeyValueListAdapter dependentAdapter = new KeyValueListAdapter(this, R.layout.mypolicy_list_item, dependents);
		
		for ( String name : p.getDependents()) {
			dependents.add( new KeyValueListItem(name,""));
		}
		ListView listDependents = (ListView) findViewById(R.id.dependent_list);
		listDependents.setAdapter(dependentAdapter);
		
	}

}
