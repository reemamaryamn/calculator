import customtkinter as ctk

ctk.set_appearance_mode("light")
ctk.set_default_color_theme("blue")

window=ctk.CTk()
window.title("GUI Calculator")
window.geometry("300x400")

background = ctk.CTkFrame(window, fg_color="#c44e83")  # Change color here
background.pack(fill="both", expand=True)

entry=ctk.CTkEntry(background, width=250, height= 50, font=("TimesNewRoman",20), justify="center")
entry.grid(row=0, column=0, columnspan=4, padx=10, pady=10)

def buttonclick(value):
    current=entry.get()
    entry.delete(0, ctk.END)
    entry.insert(0, current+value)

def clearentry():
    entry.delete(0, ctk.END)

def calculate():
    try:
        result=str(eval(entry.get()))
        entry.delete(0, ctk.END)
        entry.insert(0, result)

    except Exception:
        entry.delete(0, ctk.END)
        entry.insert(0, "Error")

buttons=[
    ("7", 1, 0), ("8", 1, 1), ("9", 1, 2), ("/", 1, 3),
    ("4", 2, 0), ("5", 2, 1), ("6", 2, 2), ("*", 2, 3),
    ("1", 3, 0), ("2", 3, 1), ("3", 3, 2), ("-", 3, 3),
    ("0", 4, 0), (".", 4, 1), ("=", 4, 2), ("+", 4, 3),
    ("C", 5, 0)
]

for (text, row, col) in buttons:
    if text=="=":
        btn=ctk.CTkButton(background, text=text, command=calculate)
    elif text=="C":
        btn=ctk.CTkButton(background, text=text, command=clearentry)
    else:
        btn=ctk.CTkButton(background, text=text, command=lambda t=text:buttonclick(t))

    btn.grid(row=row, column=col, padx=5, pady=5, sticky="nsew")

window.mainloop()
