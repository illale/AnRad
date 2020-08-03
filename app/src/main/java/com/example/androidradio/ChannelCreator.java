package com.example.androidradio;

public class ChannelCreator {
    //This class is used to prepopulate room database with radio stations
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

    public static Settings[] createSettings() {
        return new Settings[] {
            new Settings("GET_SONGS", true)
        };
    }
}
