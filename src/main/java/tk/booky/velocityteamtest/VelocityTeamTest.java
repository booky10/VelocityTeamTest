package tk.booky.velocityteamtest;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
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

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
    }
}
