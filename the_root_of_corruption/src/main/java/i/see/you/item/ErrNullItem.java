
package i.see.you.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import i.see.you.init.TheRootOfCorruptionModFluids;

public class ErrNullItem extends BucketItem {
	public ErrNullItem() {
		super(TheRootOfCorruptionModFluids.ERR_NULL.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
	}
}
