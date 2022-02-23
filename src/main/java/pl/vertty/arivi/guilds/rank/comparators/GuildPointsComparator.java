
package pl.vertty.arivi.guilds.rank.comparators;

import pl.vertty.arivi.guilds.data.guild.Guild;

import java.util.Comparator;

public class GuildPointsComparator implements Comparator<Guild>
{

    @Override
    public int compare(final Guild guild, final Guild guild2) {
        return Integer.compare(guild2.getPoints(), guild.getPoints());
    }
}
