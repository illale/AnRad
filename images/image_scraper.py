from bs4 import BeautifulSoup
import requests as req
import re

url = "https://www.radiot.fi/kanavat"

page = req.get(url)

soup = BeautifulSoup(page.content, "html.parser")

img_links = soup.find_all("a", attrs={ "href": re.compile("\/kanavat\/*") })

links = []
names = []

for div in img_links:
    
    try: 
        link = div.find("img")
        links.append(link["src"])
        print(link["src"])
    except:
        name = div.find("h2")
        print(name)

        if (name == None):
            continue
        else:
            names.append(name.get_text())

for i, el in enumerate(links):
    with open(names[i] + ".png", "wb") as t:
        t.write(req.get(el).content)

        
        
