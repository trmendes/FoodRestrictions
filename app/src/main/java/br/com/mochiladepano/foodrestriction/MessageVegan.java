package br.com.mochiladepano.foodrestriction;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

public class MessageVegan extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(
                R.layout.activity_message_vegan, container, false);

        String language = getArguments().getString(MessageLanguageSelector.ARG_LANGUAGE);

        TextView tv = (TextView) v.findViewById(R.id.tvVegegan);

        /* //TODO - Find a better way of doing it
         * I don't believe that this is the best approach to handle this problem but it is
         * the only way I found to do it so far. Do you have any better idea?
         * please help me here :D
         */

        /* Getting the current resource  and config info */
        Resources rsc =  v.getContext().getResources();
        Configuration config = rsc.getConfiguration();
        /* Saving the original locale before changing to the new one
         * just to show the texts
         */
        Locale orgLocale = config.locale;

        config.locale = new Locale(language);

        /* Setting the new locale */
        rsc.updateConfiguration(config, rsc.getDisplayMetrics());
        /* Updating the layout with the new selected language */
        tv.setText(rsc.getString(R.string.msg_vegan));

        /* Return to last locale to keep the app as it was before */
        config.locale = orgLocale;
        rsc.updateConfiguration(config, rsc.getDisplayMetrics());

        return v;
    }

}