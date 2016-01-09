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

public class FoodIconItem {

    private int restrictionType;
    private int type;
    private int nameId;
    private int iconId;

    public FoodIconItem() {

    }

    public FoodIconItem(int restrictionsType, int type, int nameId, int IconId) {
        this.restrictionType = restrictionType;
        this.type = type;
        this.nameId = nameId;
        this.iconId = iconId;
    }

    public int getRestrictionType() {
        return restrictionType;
    }

    public void setRestrictionType(int restrictionType) {
        this.restrictionType = restrictionType;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public int getNameId() {
        return nameId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
