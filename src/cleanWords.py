# with open('diccionarioCompleto.txt', encoding='utf-8') as f:
#     matches = ["á","é","í","ó","ú"]
#     for line in f:
#         # print(line.strip())
#         contents = f.readline()
#         if any(x in contents for x in matches):
#             # delete the line from the file
#             f.seek(0)
#             f.truncate()


matches = ["á","é","í","ó","ú"]

with open("diccionarioCompleto.txt", "r+", encoding='utf-8') as f:
    d = f.readlines()
    # print(d)
    f.seek(0)
    for i in d:
        print(i.strip("\n"))
        i = i.strip("\n")
        if "á" in i:
            for x in "á":
                i = i.replace(x, "a")
        if "é" in i:
            for x in "é":
                i = i.replace(x, "e")
        if "í" in i:
            for x in "í":
                i = i.replace(x, "i")
        if "ó" in i:
            for x in "ó":
                i = i.replace(x, "o")
        if "ú" in i:
            for x in "ú":
                i = i.replace(x, "u")
        if "ñ" in i:
            # delete the word if ñ is in it
            i = "\n"

                
        f.write(i.strip("\n") + "\n")
        # if any(x in i for x in matches):
        #      print(i)

        # else:
        #     f.write(i)
           
    f.truncate()

# a_file = open("diccionarioCompleto.txt", "r", encoding='utf-8')
# lines = a_file.readlines()
# print(lines)
# a_file.close()

# new_file = open("diccionarioCompleto.txt", "w", encoding='utf-8')
# for line in lines:
#     if any(x not in line for x in matches):
#         print(line)
#         # new_file.write(line)
#     else:
#         print("Linea eliminada")


# new_file.close()