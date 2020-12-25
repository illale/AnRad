import os 

def return_drawable_id(name):
    return name.lower().replace("ä", "a").replace("å", "o").replace("ö", "o").replace(" ", "_").replace("ï¿½", "a")

with open("kanavat.txt", "r") as source:
    lines = source.readlines()
    lines = sorted(lines)
    with open("ob.txt", "w") as target:
        for line in lines:
            if (len(line) < 2):
                continue
            
            name = line.split("|")[0]
            m3u_url = line.split("|")[2]

            string = "new Channel(\"{name}\", \"{audio_url}\", \"{song_url}\", R.drawable.{image}),".format(name=name.upper().replace("Ï¿½", "Ä"), audio_url=m3u_url, song_url="None", image=return_drawable_id(name))
            print(string)
            target.write(string + "\n")
    