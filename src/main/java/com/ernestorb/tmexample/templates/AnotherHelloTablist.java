package com.ernestorb.tmexample.templates;

import com.ernestorb.tablistmanager.packets.TablistTemplate;
import com.google.common.collect.Lists;


public class AnotherHelloTablist {


    public static TablistTemplate getInstance() {
        TablistTemplate template = new TablistTemplate((tablistTemplate, player) ->
                tablistTemplate.setHeader(tablistTemplate.getHeader().replaceAll("%new_placeholder%", player.getGameMode().toString()))
        );
        template.setHeader(Lists.newArrayList("&cHola", "&a¿Qué tal?"));
        template.setFooter(Lists.newArrayList("&ehttps://ernestorb.com"));
        return template;
    }

}
