/* Copyright (c) 2017 lib4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * You should have received a copy of The MIT License (MIT) along with this
 * program. If not, see <http://opensource.org/licenses/MIT/>.
 */

package org.lib4j.net;

import java.util.Base64;

public class Bearer extends AuthScheme {
  private final String token;

  public Bearer(final String token) {
    this.token = token;
    if (token == null)
      throw new NullPointerException("token == null");
  }

  protected Bearer() {
    this.token = null;
  }

  public String getToken() {
    return this.token;
  }

  @Override
  public String name() {
    return "Bearer";
  }

  @Override
  protected Bearer decode(final String authorization) {
    return new Bearer(new String(Base64.getDecoder().decode(authorization.substring(7))));
  }
}