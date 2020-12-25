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
            new Channel("AITO-ISKELMÄ", "https://supla.digitacdn.net/live/_definst_/supla/aitoiskelma/playlist.m3u8", "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=58&next_token=&limit=1", R.drawable.aito_iskelma),
            new Channel("AURAN AALLOT", "https://stream.bauermedia.fi/auranaallot/auranaallot_64.aac", "None", R.drawable.auran_aallot),
            new Channel("FUN TAMPERE", "https://st.downtime.fi/fun.mp3", "None", R.drawable.fun_tampere),
            new Channel("JÄRVIRADIO", "https://jarviradio.radiotaajuus.fi:9000/jr", "None", R.drawable.jarviradio),
            new Channel("KASARI", "https://stream.bauermedia.fi/kasari/kasari_64.aac", "https://www.kasari.fi/feed/onair", R.drawable.kasari),
            new Channel("LOOP", "https://supla.digitacdn.net/live/_definst_/supla/loop/playlist.m3u8", "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=54&next_token=&limit=1", R.drawable.loop),
            new Channel("RADIO 957", "https://stream.bauermedia.fi/radio957/radio957_64.aac", "https://www.957.fi/feed/onair", R.drawable.radio_957),
            new Channel("RADIO DEI", "https://st    ream.dei.fi:8443/yleisohjelma", "None", R.drawable.radio_dei_kajaani),
            new Channel("RADIO HELSINKI", "https://stream.radiohelsinki.fi", "None", R.drawable.radio_helsinki),
            new Channel("RADIO KAAKKO", "https://wr2.downtime.fi/kaakko.aac", "None", R.drawable.radio_kaakko),
            new Channel("RADIO KESKISUOMALAINEN", "https://cast.radiokeskisuomalainen.fi/radiokeskisuomalainen", "https://www.radiokeskisuomalainen.fi/api.json", R.drawable.radio_keskisuomalainen),
            new Channel("RADIO PATMOS", "https://s3.yesstreaming.net:9011/radio", "None", R.drawable.radio_patmos),
            new Channel("RADIO POOKI", "https://stream.bauermedia.fi/radiopooki/radiopooki_64.aac", "https://www.radiopooki.fi/feed/onair", R.drawable.radio_pooki),
            new Channel("RADIO VAASA", "https://stream.protonbroadcast.com:8443/radiovaasa.mp3", "None", R.drawable.radio_vaasa),
            new Channel("RADIO VOIMA", "https://cast2.radiovoima.fi/voima.mp3", "None", R.drawable.radio_voima),
            new Channel("SAVON AALLOT", "https://cast.savonaallot.fi/savonaallot", "None", R.drawable.savon_aallot),
            new Channel("SUOMIRÄP", "https://stream.bauermedia.fi/suomirap/suomirap_64.aac", "https://listenapi.planetradio.co.uk/api9/initdadi/suomirap", R.drawable.suomirap),
            new Channel("YLE KLASSINEN", "https://yleuni-f.akamaihd.net/i/yleliveradiohd_4@113881/master.m3u8?set-segment-duration=quality", "None", R.drawable.yle_klassinen),
            new Channel("YLE RADIO 1", "https://yleuni-f.akamaihd.net/i/yleliveradiohd_1@113878/master.m3u8?set-segment-duration=quality", "None", R.drawable.yle_radio_1),
            new Channel("YLE RADIO SUOMI", "https://yleuni-f.akamaihd.net/i/yleliveradiohd_3@113880/master.m3u8?set-segment-duration=quality", "None", R.drawable.yle_puhe),
            new Channel("YLE VEGA", "https://yleuni-f.akamaihd.net/i/yleliveradiohd_7@113884/master.m3u8?set-segment-duration=quality", "None", R.drawable.yle_puhe),
            new Channel("YLE X3M", "https://yleuni-f.akamaihd.net/i/yleliveradiohd_6@113883/master.m3u8?set-segment-duration=quality", "None", R.drawable.yle_x3m),
            new Channel("YSÄRI", "https://stream.bauermedia.fi/ysari/ysari_64.aac", "https://www.ysariradio.fi/feed/onair", R.drawable.ysari),
            new Channel("YLE SAMI", "https://yleuni-f.akamaihd.net/i/yleliveradiohd_33@113910/master.m3u8?set-segment-duration=quality", "None", R.drawable.yle_sami_radio)
        };
    }

}
