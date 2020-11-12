import hashlib

user_password = input("entrez un mot\n")
user_password_str = bytes(user_password, 'utf8')
print ('le hash est',hashlib.new('sha224', user_password_str).hexdigest(),'\nà partir de',user_password)
