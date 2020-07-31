import requests
from bs4 import BeautifulSoup
import tkinter as tk
import os
import urllib.request as rq
import getpass
def connect():
    url='http://www.google.com'
    try:
        rq.urlopen(url)
        return True
    except:
        return False

def download_image():
    if connect()==False:
        TEXT6=tk.Label(top,text='Internet not connected....')
        canvas.create_window(150,200,window=TEXT6)
        return
    try:
        username = entry.get()
        if not username:
            TEXT6=tk.Label(top,text='Field is Empty....')
            canvas.create_window(150,200,window=TEXT6)
            return
        url = r'https://www.instagram.com/{}/'
        r = requests.get(url.format(username))
        s = BeautifulSoup(r.text, 'html.parser')
        u = s.find('meta', property='og:image')
        URL = u.attrs['content']
        user=getpass.getuser()
        dir=r'C:\Users\\Desktop'
        directory=dir[:9]+user+dir[9:]
        os.chdir(directory)
        name = username + '.jpg'
        with open(name, 'wb') as pic:
            binary = requests.get(URL).content
            pic.write(binary)
            TEXT4 = tk.Label(top, text='Profile PIC Downloaded and saved on Desktop...')
            canvas.create_window(150, 200, window=TEXT4)
            TEXT5 = tk.Label(top, text=username + '.jpg')
            canvas.create_window(150, 230, window=TEXT5)
    except AttributeError:
        TEXT6=tk.Label(top,text='Username not correct....')
        canvas.create_window(150,200,window=TEXT6)
top=tk.Tk()
canvas=tk.Canvas(top,width=300,height=400)
canvas.pack()
TEXT1=tk.Label(top,text='Download Instagram Profile PIC')
TEXT2=tk.Label(top,text='Enter INSTAGRAM USERNAME below...')
canvas.create_window(150,110,window=TEXT1)
canvas.create_window(150,130,window=TEXT2)
entry=tk.Entry(top)
canvas.create_window(150,150,window=entry)
button=tk.Button(text='DOWNLOAD',command=download_image)
canvas.create_window(150,180,window=button)
top.mainloop()