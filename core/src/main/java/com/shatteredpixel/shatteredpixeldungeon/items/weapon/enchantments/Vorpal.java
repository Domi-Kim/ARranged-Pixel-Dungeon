/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2019 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.items.weapon.enchantments;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Bleeding;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.effects.Splash;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.Weapon;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.TrueRunicBlade;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSprite;
import com.watabou.utils.PointF;
import com.watabou.utils.Random;

public class Vorpal extends Weapon.Enchantment {

	private static ItemSprite.Glowing RED = new ItemSprite.Glowing( 0xAA6666 );

	@Override
	public int proc(Weapon weapon, Char attacker, Char defender, int damage) {
		int level = Math.max( 0, weapon.level() );

		// lvl 0 - 13%
		// lvl 1 - 22%
		// lvl 2 - 30%
		float procChance;
		if (weapon instanceof TrueRunicBlade) {
			procChance = 1;
		} else {
			procChance = (level+1f)/(level+8f) * procChanceMultiplier(attacker);
		}
		if (Random.Float() < procChance) {

			Buff.affect(defender, Bleeding.class).set(damage/10f);
			Splash.at( defender.sprite.center(), -PointF.PI / 2, PointF.PI / 6,
					defender.sprite.blood(), 10 );

		}

		return damage;
	}

	@Override
	public ItemSprite.Glowing glowing() {
		return RED;
	}

}
