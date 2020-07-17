package com.example.androidradio;

import java.util.List;

public class ChannelCreator {
    //Use this class to prepopulate room database
    String[] channels = {"https://yleuni-f.akamaihd.net/i/yleliveradiohd_2@113879/index_64_a-p.m3u8?sd=10&rebase=on",
            "https://stream.bauermedia.fi/radionova/radionova_64.aac",
            "https://stream.bauermedia.fi/suomirock/suomirock_64.aac",
            "https://stream.bauermedia.fi/nrj/nrj_64.aac",
            "https://stream.bauermedia.fi/iskelma/iskelma_64.aac",
            "https://yleuni-f.akamaihd.net/i/yleliveradiohd_5@113882/index_128_a-p.m3u8?sd=10&rebase=on",
            "https://digitacdn.akamaized.net/hls/live/629243/radiohelmi/master-128000.m3u8",
            "https://digitacdn.akamaized.net/hls/live/629243/radiorock/master.m3u8",
            "https://digitacdn.akamaized.net/hls/live/629243/radiosuomipop/master-128000.m3u8",
            "https://supla.digitacdn.net/live/_definst_/supla/aitoiskelma/playlist.m3u8"
    };

    String[] channelSongs = {"https://areena.api.yle.fi/v1/songs/current.json?app_id=areena_web_personal_prod&app_key=6c64d890124735033c50099ca25dd2fe&client=yle-areena-web&language=fi&v=7&serviceId=ylex",
            "https://www.radionova.fi/feed/onair",
            "https://www.radiosuomirock.fi/feed/onair",
            "https://nrj.fi/webplayer/json/energy.json",
            "https://www.iskelma.fi/feed/onair",
            "None",
            "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=57&next_token=&limit=1",
            "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=52&next_token=&limit=1",
            "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=53&next_token=&limit=1",
            "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=58&next_token=&limit=1"
    };
    String[] channelNames = {"YLEX", "RADIO NOVA", "SUOMI-ROCK", "NRJ", "ISKELMÄ", "PUHE", "RADIO HELMI", "RADIO ROCK", "SUOMI-POP", "AITO-ISKELMÄ"};
    int[] images = {R.drawable.ylex, R.drawable.radionova, R.drawable.suomirock, R.drawable.nrj, R.drawable.iskelma_valt, R.drawable.yle_puhe, R.drawable.helmiradio, R.drawable.radio_rock, R.drawable.radio_suomipop, R.drawable.aito_iskelma};

    public static Channel[] createChannels() {
        return new Channel[] {
            new Channel("YLEX", "https://yleuni-f.akamaihd.net/i/yleliveradiohd_2@113879/index_64_a-p.m3u8?sd=10&rebase=on", "https://areena.api.yle.fi/v1/songs/current.json?app_id=areena_web_personal_prod&app_key=6c64d890124735033c50099ca25dd2fe&client=yle-areena-web&language=fi&v=7&serviceId=ylex", R.drawable.ylex),
            new Channel("RADIO NOVA", "https://stream.bauermedia.fi/radionova/radionova_64.aac", "https://www.radionova.fi/feed/onair", R.drawable.radionova),
            new Channel("SUOMI-ROCK", "https://stream.bauermedia.fi/suomirock/suomirock_64.aac", "https://www.radiosuomirock.fi/feed/onair", R.drawable.suomirock),
            new Channel("NRJ", "https://stream.bauermedia.fi/nrj/nrj_64.aac", "https://nrj.fi/webplayer/json/energy.json", R.drawable.nrj),
            new Channel("ISKELMÄ", "https://stream.bauermedia.fi/iskelma/iskelma_64.aac", "https://www.iskelma.fi/feed/onair", R.drawable.iskelma_valt),
            new Channel("PUHE", "https://yleuni-f.akamaihd.net/i/yleliveradiohd_5@113882/index_128_a-p.m3u8?sd=10&rebase=on", "None", R.drawable.yle_puhe),
            new Channel("RADIO HELMI", "https://digitacdn.akamaized.net/hls/live/629243/radiohelmi/master-128000.m3u8", "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=57&next_token=&limit=1", R.drawable.helmiradio),
            new Channel("RADIO ROCK", "https://digitacdn.akamaized.net/hls/live/629243/radiorock/master.m3u8", "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=52&next_token=&limit=1", R.drawable.radio_rock),
            new Channel("SUOMI-POP", "https://digitacdn.akamaized.net/hls/live/629243/radiosuomipop/master-128000.m3u8", "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=53&next_token=&limit=1", R.drawable.radio_suomipop),
            new Channel("AITO-ISKELMÄ", "https://supla.digitacdn.net/live/_definst_/supla/aitoiskelma/playlist.m3u8", "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=58&next_token=&limit=1", R.drawable.aito_iskelma)
        };
    }
}
