package mx.com.vrm.viai.configuration.util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class Regex.
 */
public class Regex {

	/**
	 * Escape.
	 *
	 * @param pattern
	 *            the pattern
	 * @return the string
	 */
	public static String escape(final String pattern) {
		return Pattern.quote(pattern);
	}

	/**
	 * Gets the lines.
	 *
	 * @param arg
	 *            the arg
	 * @return the lines
	 */
	public static String[] getLines(final String arg) {
		if (arg == null) {
			return new String[] {};
		} else {
			final String[] temp = arg.split("[\r\n]{1,2}");
			final int tempLength = temp.length;
			final String[] output = new String[tempLength];
			for (int i = 0; i < tempLength; i++) {
				output[i] = new String(temp[i].trim());
			}
			return output;
		}
	}

	/**
	 * Matches.
	 *
	 * @param str
	 *            the str
	 * @param pat
	 *            the pat
	 * @return true, if successful
	 */
	public static boolean matches(final Object str, final Pattern pat) {
		return new Regex(str, pat).matches();
	}

	/**
	 * Matches.
	 *
	 * @param page
	 *            the page
	 * @param string
	 *            the string
	 * @return true, if successful
	 */
	public static boolean matches(final Object page, final String string) {
		return new Regex(page, string).matches();
	}

	/**
	 * Replace.
	 *
	 * @param text
	 *            the text
	 * @param regex
	 *            the regex
	 * @param replacement
	 *            the replacement
	 * @return the string
	 */
	public static String replace(final String text, final String regex, final String replacement) {

		return Pattern.compile(regex, Pattern.DOTALL | Pattern.MULTILINE).matcher(text).replaceAll(replacement);
	}

	/** The matcher. */
	private Matcher matcher;

	/** The mem opt. */
	private boolean memOpt = true;

	/**
	 * Instantiates a new regex.
	 *
	 * @param matcher
	 *            the matcher
	 */
	public Regex(final Matcher matcher) {
		if (matcher != null) {
			this.matcher = matcher;
		}
	}

	/**
	 * Instantiates a new regex.
	 *
	 * @param data
	 *            the data
	 * @param pattern
	 *            the pattern
	 */
	public Regex(final Object data, final Pattern pattern) {
		this(data.toString(), pattern);
	}

	/**
	 * Instantiates a new regex.
	 *
	 * @param data
	 *            the data
	 * @param pattern
	 *            the pattern
	 */
	public Regex(final Object data, final String pattern) {
		this(data.toString(), pattern);
	}

	/**
	 * Instantiates a new regex.
	 *
	 * @param data
	 *            the data
	 * @param pattern
	 *            the pattern
	 * @param flags
	 *            the flags
	 */
	public Regex(final Object data, final String pattern, final int flags) {
		this(data.toString(), pattern, flags);
	}

	/**
	 * Instantiates a new regex.
	 *
	 * @param data
	 *            the data
	 * @param pattern
	 *            the pattern
	 */
	public Regex(final String data, final Pattern pattern) {
		if (data != null && pattern != null) {
			this.matcher = pattern.matcher(data);
		}
	}

	/**
	 * Instantiates a new regex.
	 *
	 * @param data
	 *            the data
	 * @param pattern
	 *            the pattern
	 */
	public Regex(final String data, final String pattern) {
		if (data != null && pattern != null) {
			this.matcher = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.DOTALL).matcher(data);
		}
	}

	/**
	 * Instantiates a new regex.
	 *
	 * @param data
	 *            the data
	 * @param pattern
	 *            the pattern
	 * @param flags
	 *            the flags
	 */
	public Regex(final String data, final String pattern, final int flags) {
		if (data != null && pattern != null) {
			this.matcher = Pattern.compile(pattern, flags).matcher(data);
		}
	}

	/**
	 * Count.
	 *
	 * @return the int
	 */
	public int count() {
		if (this.matcher == null) {
			return 0;
		} else {
			this.matcher.reset();
			int c = 0;
			final Matcher matchertmp = this.matcher;
			while (matchertmp.find()) {
				c++;
			}
			return c;
		}
	}

	/**
	 * Gets the column.
	 *
	 * @param x
	 *            the x
	 * @return the column
	 */
	public String[] getColumn(int x) {
		if (this.matcher == null) {
			return null;
		} else {
			x++;
			final Matcher matcher = this.matcher;
			matcher.reset();

			final java.util.List<String> ar = new ArrayList<String>();
			while (matcher.find()) {
				String tmp = matcher.group(x);
				if (tmp != null && this.memOpt) {
					tmp = new String(tmp);
				}
				ar.add(tmp);
			}
			return ar.toArray(new String[ar.size()]);
		}
	}

	/**
	 * Gets the match.
	 *
	 * @param group
	 *            the group
	 * @return the match
	 */
	public String getMatch(final int group) {
		if (this.matcher != null) {
			final Matcher matcher = this.matcher;
			matcher.reset();
			if (matcher.find()) {
				final String ret = matcher.group(group + 1);
				if (ret != null && this.memOpt) {
					return new String(ret);
				}
				return ret;
			}
		}
		return null;
	}

	/**
	 * Gets the match.
	 *
	 * @param entry
	 *            the entry
	 * @param group
	 *            the group
	 * @return the match
	 */
	public String getMatch(int entry, final int group) {
		if (this.matcher != null) {
			final Matcher matcher = this.matcher;
			matcher.reset();
			// group++;
			entry++;
			int groupCount = 0;
			while (matcher.find()) {
				if (groupCount == group) {
					final String ret = matcher.group(entry);
					if (ret != null && this.memOpt) {
						return new String(ret);
					}
					return ret;
				}
				groupCount++;
			}
		}
		return null;
	}

	/**
	 * Gets the matcher.
	 *
	 * @return the matcher
	 */
	public Matcher getMatcher() {
		if (this.matcher != null) {
			this.matcher.reset();
		}
		return this.matcher;
	}

	/**
	 * Gets the matches.
	 *
	 * @return the matches
	 */
	public String[][] getMatches() {
		if (this.matcher == null) {
			return null;
		} else {
			final Matcher matcher = this.matcher;
			matcher.reset();
			final java.util.List<String[]> ar = new ArrayList<String[]>();
			while (matcher.find()) {
				final int c = matcher.groupCount();
				int d = 1;
				String[] group;
				if (c == 0) {
					group = new String[c + 1];
					d = 0;
				} else {
					group = new String[c];
				}

				for (int i = d; i <= c; i++) {
					String tmp = matcher.group(i);
					if (tmp != null && this.memOpt) {
						tmp = new String(tmp);
					}
					group[i - d] = tmp;
				}
				ar.add(group);
			}
			return ar.size() == 0 ? new String[][] {} : ar.toArray(new String[][] {});
		}
	}

	/**
	 * Gets the row.
	 *
	 * @param y
	 *            the y
	 * @return the row
	 */
	public String[] getRow(final int y) {
		if (this.matcher != null) {
			final Matcher matcher = this.matcher;
			matcher.reset();
			int groupCount = 0;
			while (matcher.find()) {
				if (groupCount == y) {
					final int c = matcher.groupCount();

					final String[] group = new String[c];

					for (int i = 1; i <= c; i++) {
						String tmp = matcher.group(i);
						if (tmp != null && this.memOpt) {
							tmp = new String(tmp);
						}
						group[i - 1] = tmp;
					}
					return group;
				}
				groupCount++;
			}
		}
		return null;
	}

	/**
	 * Matches.
	 *
	 * @return true, if successful
	 */
	public boolean matches() {
		final Matcher matcher = this.matcher;
		if (matcher == null) {
			return false;
		} else {
			matcher.reset();
			return matcher.find();
		}
	}

	/**
	 * Sets the matcher.
	 *
	 * @param matcher
	 *            the new matcher
	 */
	public void setMatcher(final Matcher matcher) {
		this.matcher = matcher;
	}

	/**
	 * Sets the memory optimized.
	 *
	 * @param t
	 *            the t
	 * @return the regex
	 */
	public Regex setMemoryOptimized(final boolean t) {
		this.memOpt = t;
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder ret = new StringBuilder();
		final String[][] matches = this.getMatches();
		final int matchesLength = matches.length;
		String[] match;
		int matchLength;
		for (int i = 0; i < matchesLength; i++) {
			match = matches[i];
			matchLength = match.length;
			for (int j = 0; j < matchLength; j++) {
				ret.append("match[");
				ret.append(i);
				ret.append("][");
				ret.append(j);
				ret.append("] = ");
				ret.append(match[j]);
				ret.append(System.getProperty("line.separator"));
			}
		}
		this.matcher.reset();
		return ret.toString();
	}
}
