import requests
import os
import tqdm
chunk_size=1024
url='https://gist.githubusercontent.com/curran/a08a1080b88344b0c8a7/raw/639388c2cbc2120a14dcf466e85730eb8be498bb/iris.csv'
print('Downloading....')
r=requests.get(url,stream=True)
file_name='iris.csv'
total_size=int(r.headers['content-length'])
os.chdir(r'C:\Data')
with open(file_name,'wb') as output_file:
    for data in tqdm.tqdm(iterable=r.iter_content(chunk_size=chunk_size),total=total_size/chunk_size,unit='KB'):
        output_file.write(data)
print('Download finish...')