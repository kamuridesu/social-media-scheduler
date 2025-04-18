import Cookies from "js-cookie";

export function setCookie(name: string, value: string, options?: Cookies.CookieAttributes) {
    Cookies.set(name, value, {
        expires: 7, // 7 days
        secure: process.env.NODE_ENV === "production",
        sameSite: 'strict',
        ...options
    });
}

export function getCookie(name: string): string | undefined {
    return Cookies.get(name);
}
