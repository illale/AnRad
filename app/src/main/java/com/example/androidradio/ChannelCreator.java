package com.example.androidradio;

public class ChannelCreator {
    //This class is used to prepopulate room database with radio stations
    public static Channel[] createChannels() {
        return new Channel[] {
            new Channel("Ylex", "https://yleuni-f.akamaihd.net/i/yleliveradiohd_2@113879/index_64_a-p.m3u8?sd=10&rebase=on", "https://areena.api.yle.fi/v1/songs/current.json?app_id=areena_web_personal_prod&app_key=6c64d890124735033c50099ca25dd2fe&client=yle-areena-web&language=fi&v=7&serviceId=ylex", R.drawable.ylex),
            new Channel("Radio Nova", "https://stream.bauermedia.fi/radionova/radionova_64.aac", "https://www.radionova.fi/feed/onair", R.drawable.radionova),
            new Channel("Suomi-Rock", "https://stream.bauermedia.fi/suomirock/suomirock_64.aac", "https://www.radiosuomirock.fi/feed/onair", R.drawable.suomirock),
            new Channel("NRJ", "https://stream.bauermedia.fi/nrj/nrj_64.aac", "https://nrj.fi/webplayer/json/energy.json", R.drawable.nrj),
            new Channel("Iskelmä", "https://stream.bauermedia.fi/iskelma/iskelma_64.aac", "https://www.iskelma.fi/feed/onair", R.drawable.iskelma_valt),
            new Channel("Yle Puhe", "https://yleuni-f.akamaihd.net/i/yleliveradiohd_5@113882/index_128_a-p.m3u8?sd=10&rebase=on", "None", R.drawable.yle_puhe),
            new Channel("Radio Helmi", "https://digitacdn.akamaized.net/hls/live/629243/radiohelmi/master-128000.m3u8", "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=57&next_token=&limit=1", R.drawable.helmiradio),
            new Channel("Radio Rock", "https://digitacdn.akamaized.net/hls/live/629243/radiorock/master.m3u8", "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=52&next_token=&limit=1", R.drawable.radio_rock),
            new Channel("Suomi-Pop", "https://digitacdn.akamaized.net/hls/live/629243/radiosuomipop/master-128000.m3u8", "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=53&next_token=&limit=1", R.drawable.radio_suomipop),
            new Channel("Aito-Iskelmä", "https://supla.digitacdn.net/live/_definst_/supla/aitoiskelma/playlist.m3u8", "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=58&next_token=&limit=1", R.drawable.aito_iskelma),
            new Channel("Auran Aallot", "https://stream.bauermedia.fi/auranaallot/auranaallot_64.aac", "None", R.drawable.auran_aallot),
            new Channel("Fun Tampere", "https://st.downtime.fi/fun.mp3", "None", R.drawable.fun_tampere),
            new Channel("Järviradio", "https://jarviradio.radiotaajuus.fi:9000/jr", "None", R.drawable.jarviradio),
            new Channel("Kasari", "https://stream.bauermedia.fi/kasari/kasari_64.aac", "https://www.kasari.fi/feed/onair", R.drawable.kasari),
            new Channel("Loop", "https://supla.digitacdn.net/live/_definst_/supla/loop/playlist.m3u8", "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=54&next_token=&limit=1", R.drawable.loop),
            new Channel("Radio 957", "https://stream.bauermedia.fi/radio957/radio957_64.aac", "https://www.957.fi/feed/onair", R.drawable.radio_957),
            new Channel("Radio Dei", "https://stream.dei.fi:8443/yleisohjelma", "None", R.drawable.radio_dei_kajaani),
            new Channel("Radio Helsinki", "https://stream.radiohelsinki.fi", "None", R.drawable.radio_helsinki),
            new Channel("Radio Kaakko", "https://wr2.downtime.fi/kaakko.aac", "None", R.drawable.radio_kaakko),
            new Channel("Radio Keskisuomalainen", "https://cast.radiokeskisuomalainen.fi/radiokeskisuomalainen", "https://www.radiokeskisuomalainen.fi/api.json", R.drawable.radio_keskisuomalainen),
            new Channel("Radio Patmos", "https://s3.yesstreaming.net:9011/radio", "None", R.drawable.radio_patmos),
            new Channel("Radio Pooki", "https://stream.bauermedia.fi/radiopooki/radiopooki_64.aac", "https://www.radiopooki.fi/feed/onair", R.drawable.radio_pooki),
            new Channel("Radio Vaasa", "https://stream.protonbroadcast.com:8443/radiovaasa.mp3", "None", R.drawable.radio_vaasa),
            new Channel("Radio Voima", "https://cast2.radiovoima.fi/voima.mp3", "None", R.drawable.radio_voima),
            new Channel("Savon Aallot", "https://cast.savonaallot.fi/savonaallot", "None", R.drawable.savon_aallot),
            new Channel("Suomiräp", "https://stream.bauermedia.fi/suomirap/suomirap_64.aac", "https://listenapi.planetradio.co.uk/api9/initdadi/suomirap", R.drawable.suomirap),
            new Channel("Yle Klassinen", "https://yleuni-f.akamaihd.net/i/yleliveradiohd_4@113881/master.m3u8?set-segment-duration=quality", "None", R.drawable.yle_klassinen),
            new Channel("Yle Radio 1", "https://yleuni-f.akamaihd.net/i/yleliveradiohd_1@113878/master.m3u8?set-segment-duration=quality", "None", R.drawable.yle_radio_1),
            new Channel("Yle Radio Suomi", "https://yleuni-f.akamaihd.net/i/yleliveradiohd_3@113880/master.m3u8?set-segment-duration=quality", "None", R.drawable.yle_puhe),
            new Channel("Yle Vega", "https://yleuni-f.akamaihd.net/i/yleliveradiohd_7@113884/master.m3u8?set-segment-duration=quality", "None", R.drawable.yle_puhe),
            new Channel("Yle X3M", "https://yleuni-f.akamaihd.net/i/yleliveradiohd_6@113883/master.m3u8?set-segment-duration=quality", "None", R.drawable.yle_x3m),
            new Channel("Ysäri", "https://stream.bauermedia.fi/ysari/ysari_64.aac", "https://www.ysariradio.fi/feed/onair", R.drawable.ysari),
            new Channel("Yle Sami", "https://yleuni-f.akamaihd.net/i/yleliveradiohd_33@113910/master.m3u8?set-segment-duration=quality", "None", R.drawable.yle_sami_radio)
        };
    }

}
