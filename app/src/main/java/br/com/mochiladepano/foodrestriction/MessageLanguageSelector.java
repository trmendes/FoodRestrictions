package br.com.mochiladepano.foodrestriction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MessageLanguageSelector extends ListFragment {

    private ListView languageListView;
    private ArrayAdapter arrayAdapter;
    public static final String ARG_LANGUAGE = "arg_language";

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Bundle args = new Bundle();
        Intent intent = new Intent(getContext(), MessagesTab.class);

        switch (position) {
            case 0: //English
                args.putString(MessageLanguageSelector.ARG_LANGUAGE, "en");
                break;
            case 1: //Portuguese
                args.putString(MessageLanguageSelector.ARG_LANGUAGE, "pt");
                break;
        }

        intent.putExtras(args);
        startActivity(intent);
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(
                R.layout.activity_message_lang_selector, container, false);

        arrayAdapter = ArrayAdapter.createFromResource(v.getContext(),
                R.array.languages_messages_array, android.R.layout.simple_list_item_1);

        setListAdapter(arrayAdapter);

        return v;
    }

}
