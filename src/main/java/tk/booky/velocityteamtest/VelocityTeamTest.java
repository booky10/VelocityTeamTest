package tk.booky.velocityteamtest;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PostLoginEvent;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.team.CollisionRule;
import com.velocitypowered.api.team.NameTagVisibility;
import com.velocitypowered.api.team.Team;
import com.velocitypowered.api.team.TeamColor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.slf4j.Logger;

@Plugin(
    id = "velocity_team_test",
    name = "VelocityTeamTest",
    version = "@PLUGIN_VERSION@",
    description = "A simple plugin created to test the velocity team api.",
    url = "https://booky.tk/",
    authors = {"booky10"}
)
public class VelocityTeamTest {

    @Inject @SuppressWarnings("unused") private ProxyServer server;
    @Inject @SuppressWarnings("unused") private Logger logger;
    private Team team;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        // The display name of the test team
        Component displayName = Component.text("Team Display Name", NamedTextColor.AQUA);

        // Create the test team
        team = server.getTeamManager().createTeam("test_team", displayName);

        // Change the team color (and the name color of entries)
        team.setColor(TeamColor.DARK_AQUA);

        // Change the prefix for the team
        team.setPrefix(Component.text("prefix ", NamedTextColor.GREEN));

        // Change the suffix for the team
        team.setSuffix(Component.text(" suffix", NamedTextColor.DARK_GREEN));

        // Don't allow entries to see each other if invisible
        team.setCanSeeFriendlyInvisibles(false);

        // Don't allow entries to hit each other (doesn't work, because the server does the damage)
        team.setAllowFriendlyFire(false);

        // Hide name tags for every entry in this team
        team.setNameTagVisibility(NameTagVisibility.NEVER);

        // Don't allow them to collide with others
        team.setCollisionRule(CollisionRule.NEVER);
    }

    @Subscribe
    public void postPlayerConnect(PostLoginEvent event) {
        team.addEntry(event.getPlayer().getUsername());
    }
}
