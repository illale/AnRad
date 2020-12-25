import requests as req  
from bs4 import BeautifulSoup
import re

search_links = []

with open("kanavat.txt", "r") as source:
    for line in source.readlines():
        if (len(line) < 2):
            continue
        
        links = line.split("|")

        search_links.append(links[1])

complete = []

for link in search_links:
    page = req.get(link)

    soup = BeautifulSoup(page.content, "html.parser")

    meu8s = soup.find("a" , attrs={ "href": re.compile("(/.m3u8/|/.m3u/)")})
    complete.append(meu8s)

for thing in complete:
    print(thing)