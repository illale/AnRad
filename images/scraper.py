import requests as req
from bs4 import BeautifulSoup


url = "https://www.mediamonitori.fi/index.php/tietosivut/nettiradiot"

page = req.get(url)

soup = BeautifulSoup(page.content, "html.parser", from_encoding="utf-8")

tds = soup.find_all('td', class_='taulukko')

a_elements = []


with open("kanavat.txt", "w") as target:

    for i in range(0, len(tds), 3):
        try:
            
            link1 = tds[i].find("a")["href"]
            link2 = tds[i+1].find("a")["href"]
            link3 = tds[i+2].find("a")["href"]
            channel_name = tds[i].find("a").text.strip()
            print(channel_name)

            target.write(channel_name + "|" + link1 + "|" + link2 + "|" + link3 + "\n\n")
            
        except:
            print("No href")