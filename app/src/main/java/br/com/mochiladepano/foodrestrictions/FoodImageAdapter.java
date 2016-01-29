/*
 * Copyright (C) 2015-2016 The Food Restriction Project Team
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package br.com.mochiladepano.foodrestrictions;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

class FoodImageAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<FoodIconItem> iconList;

    public FoodImageAdapter(Context c, List<FoodIconItem> iconList) {
        mContext = c;
        this.iconList = iconList;
    }

    public int getCount() {
        return iconList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setPadding(10, 10, 10, 10);

        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(iconList.get(position).getIconId());

        return imageView;
    }
}
