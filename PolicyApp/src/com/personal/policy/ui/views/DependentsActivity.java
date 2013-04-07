package com.personal.policy.ui.views;

import java.util.ArrayList;
import java.util.List;

import com.personal.policy.R;
import com.personal.policy.ui.KeyValueListAdapter;
import com.personal.policy.ui.KeyValueListItem;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class DependentsActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		List<KeyValueListItem> dependents = new  ArrayList<KeyValueListItem>();
		KeyValueListAdapter dependentAdapter = new KeyValueListAdapter(this, R.layout.mypolicy_list_item, dependents);
		
//		for ( String name : p.getDependents()) {
//			items.add( new KeyValueListItem(name,""));
//		}
//		ListView listDependents = (ListView) findViewById(R.id.dependent_list);
//		listDependents.setAdapter(dependentAdapter);
	}

}
