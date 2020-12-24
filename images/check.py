import os

files = [f for f in os.listdir(".") if os.path.isfile(f)]

with open("kanavat.txt", "r") as source:
    lines = source.readlines()

    for line in lines:
        if (len(line) < 1):
            continue

        info = line.split("|")

        if (info[0] + ".png" in files):
            continue
        else:
            print(info[0] + ".png")
