import os

files = [f for f in os.listdir(".") if os.path.isfile(f)]

for file in files:
    os.rename(file, file.replace(" ", "_"))
