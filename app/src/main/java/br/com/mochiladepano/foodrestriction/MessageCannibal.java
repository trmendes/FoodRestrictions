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

public class MessageCannibal extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(
                R.layout.activity_message_cannibal, container, false);

        String language = getArguments().getString(MessageLanguageSelector.ARG_LANGUAGE);

        TextView tv = (TextView) v.findViewById(R.id.tvCannibal);

        /* Getting the current resource  and config info */
        Resources rsc =  v.getContext().getResources();
        Configuration config = rsc.getConfiguration();
        /* Saving the original locale before changing to the new one
         * just to show the texts
         */
        Locale orgLocale = config.locale;

        /* Changing the language to the one the user have selected based on the
         * Languages.xml file
         */
        config.locale = new Locale(language);

        /* Setting the new locale */
        rsc.updateConfiguration(config, rsc.getDisplayMetrics());
        /* Updating the layout with the new selected language */
        tv.setText(rsc.getString(R.string.msg_joke_cannibal));

        /* Return to last locale to keep the app as it was before */
        config.locale = orgLocale;
        rsc.updateConfiguration(config, rsc.getDisplayMetrics());

        return v;
    }

}